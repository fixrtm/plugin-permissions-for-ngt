package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.client.methods.CloseableHttpResponse
import org.gradle.api.*
import org.gradle.api.internal.DefaultPolymorphicDomainObjectContainer
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.bundling.AbstractArchiveTask
import org.gradle.kotlin.dsl.*
import java.net.URI
import kotlin.reflect.cast

internal fun CloseableHttpClient.executeWithStatusCheck(request: HttpUriRequest) =
    (this as HttpClient).executeWithStatusCheck(request) as CloseableHttpResponse

internal fun HttpClient.executeWithStatusCheck(request: HttpUriRequest) = execute(request)
    .apply {
        if (statusLine.statusCode in 400 until 600)
            error("returns error status code: ${statusLine.statusCode}: ${request.uri}")
    }

internal fun <T> Project.taskContainer(
    elementType: kotlin.reflect.KClass<T>,
    prefix: String,
) where T : Task, T : NameHolder = TaskContainerBuilder(project, elementType, prefix)

internal class TaskContainerBuilder<T>(
    private val project: Project,
    elementType: kotlin.reflect.KClass<T>,
    private val prefix: String,
) where T : Task, T : NameHolder {
    private val base = project.objects.polymorphicDomainObjectContainer(elementType) { it.otherName }

    fun build(): org.gradle.api.PolymorphicDomainObjectContainer<T> = base

    fun <U : T>register(kClass: kotlin.reflect.KClass<U>) = apply {
        base.registerFactory(kClass.java, project.taskRegisteringFactory(prefix, kClass.java))
    }
}

private fun <T> Project.taskRegisteringFactory(prefix: String, type: Class<T>): NamedDomainObjectFactory<T>
        where T : Task, T : NameHolder {
    return NamedDomainObjectFactory { name ->
        @OptIn(ExperimentalStdlibApi::class)
        tasks.create("$prefix${name.replaceFirstChar(Char::uppercase)}", type) {
            otherName = name
        }
    }
}

//TODO: this calls internal apis. upgrade as needed
fun <T : Any> org.gradle.api.model.ObjectFactory.polymorphicDomainObjectContainer(elementType: kotlin.reflect.KClass<T>, namer: Namer<T>) = kotlin.run {
    fun <T : Any, R : Any> T.reflectionGet(name: String, type: kotlin.reflect.KClass<R>): R? =
        this::class.java.getDeclaredField(name)
            .apply { isAccessible = true }
            .get(this)
            ?.let(type::cast)

    val collectionFactory = this.reflectionGet("domainObjectCollectionFactory",
        org.gradle.api.internal.collections.DomainObjectCollectionFactory::class)!!
    val collectionCallbackActionDecorator = collectionFactory.reflectionGet("collectionCallbackActionDecorator",
        org.gradle.api.internal.CollectionCallbackActionDecorator::class)!!
    val instantiator = collectionFactory.reflectionGet("instantiatorFactory",
        org.gradle.internal.instantiation.InstantiatorFactory::class)!!
        .decorateLenient()

    @Suppress("UNCHECKED_CAST")
    return@run instantiator.newInstance(org.gradle.api.internal.DefaultPolymorphicDomainObjectContainer::class.java,
        elementType.java, instantiator, namer, collectionCallbackActionDecorator) 
            as org.gradle.api.ExtensiblePolymorphicDomainObjectContainer<T>
}

fun PolymorphicDomainObjectContainer<SetupMod>.creatingCurse(projectId: Int, fileId: Int) = creating(DownloadCurseMod::class) {
    this.projectId.set(projectId)
    this.fileId.set(fileId)
}

fun PolymorphicDomainObjectContainer<SetupMod>.creatingURI(uri: URI) = creating(DownloadHttpMod::class) {
    this.uri.set(uri)
}
//
//fun PolymorphicDomainObjectContainer<SetupMod>.creatingByArchiveTask(sourceTask: AbstractArchiveTask) = creating(ModByArchiveTask::class) {
//    this.sourceTask.set(sourceTask)
//}

fun PolymorphicDomainObjectContainer<SetupMod>.creatingByArchiveTask(sourceTask: Provider<out AbstractArchiveTask>) = creating(ModByArchiveTask::class) {
    this.sourceTask.set(sourceTask)
}

fun PolymorphicDomainObjectContainer<SetupServer>.creatingMohist(version: String, buildNumber: Int) = creating(DownloadMohistServer::class) {
    this.version.set(version)
    this.buildNumber.set(buildNumber)
}
