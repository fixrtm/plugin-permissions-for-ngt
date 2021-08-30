/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.apache.http.client.HttpClient
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.net.URI

class DownloadAction(
    task: Task,
    val computeDownloadSource: (client: HttpClient) -> URI,
) {
    companion object {
        fun simple(task: Task, computeDownloadSource: () -> URI) = DownloadAction(task) { computeDownloadSource() }
    }

    @OutputFile
    val targetFile = task.project.objects.fileProperty()
        .convention(task.project.layout.buildDirectory.file("downloaded/${task.name}.jar"))


    @TaskAction
    fun download() {
        HttpClients.custom()
            .setDefaultRequestConfig(RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000 * 30)
                .build())
            .setUserAgent("Mozilla/5.0 (java;apache-http-client)  plugin-permissions-for-ngt-build-plugin/1")
            .build().use { client ->
                val url = computeDownloadSource(client)
                client.executeWithStatusCheck(HttpGet(url)).use { response ->
                    targetFile.get().asFile.outputStream().use { fileOut ->
                        response.entity.writeTo(fileOut)
                    }
                }
            }
    }
}
