<!--
Copyright (C) 2021 anatawa12 and other contributors

This file is/was a part of plugin-permissions-for-ngt,
which is released under GNU GPL v3.

See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
-->

Plugin permissions for NGT permissions
====

<small>A project of [fixRTM](https://github.com/fixrtm) </small>

[![Discord](https://img.shields.io/discord/749186892733480970.svg?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/qFKcUXX)
[![Github Actions](https://img.shields.io/github/workflow/status/fixrtm/plugin-permissions-for-ngt/Java%20CI%20with%20Gradle/master?logo=github)](https://github.com/fixrtm/plugin-permissions-for-ngt/actions)
[![Github Release](https://img.shields.io/github/v/release/fixrtm/plugin-permissions-for-ngt?logo=github)](https://github.com/fixrtm/plugin-permissions-for-ngt/releases/latest)
<!--
[![Curse Download](https://img.shields.io/badge/CurseForge-download-brightgreen?logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/fixrtm)
-->

The server-side only mod to use permissions of plugins as NGTLib's permissions.

## System requirements

- Java 8 (openjdk8 is recommended)
- [NGTLib] for the minecraft version you want to use.

  This mod is tested with 
  - [KaizPatchX] 1.3.0
  - [fixRTM] SNAPSHOT-2021-08-15-06-27-14 with [NGTLib] 2.4.19-35 and [RTM] 2.4.22-40
  - [NGTLib] 1.7.10.32 with [RTM] 1.7.10.41
  - [NGTLib] 2.4.19-35 with [RTM] 2.4.22-40

- Plugin+Forge server.

  Currently, this mod supports [Bukkit]/[Spigot]+[Forge] servers,
  formerly known as Cauldron/[KCauldron]/[Thermos], like [Mohist].

  This mod is tested with [Mohist] version 1.7.10 build 40 and version 1.12.2 build 248.

This mod is server-side only mod so you don't need to install on client side and 
on client side, this mod will not work because this is depending on bukkit.

[Bukkit]: https://bukkit.org/
[Spigot]: https://www.spigotmc.org/
[Forge]: https://forums.minecraftforge.net/
[KCauldron]: https://github.com/djoveryde/KCauldron
[Thermos]: https://github.com/CyberdyneCC/Thermos
[Mohist]: https://mohistmc.com/
[KaizPatchX]: https://github.com/Kai-Z-JP/KaizPatchX
[fixRTM]: https://www.curseforge.com/minecraft/mc-mods/fixrtm
[NGTLib]: https://www.curseforge.com/minecraft/mc-mods/ngtlib
[RTM]: https://www.curseforge.com/minecraft/mc-mods/realtrainmod

## How to install

1. Please download the latest version from [latest version tag page].
2. Please install into `mods` directory.
3. Then please start minecraft server.

[latest version tag page]: https://github.com/anatawa12/plugin-permissions-for-ngt/releases/latest

## How to grant permission

This plugin registers and checks ngt's permissions to plugin permission with appending `ngt-permissions.` as prefix.
So, to grant `editRail`, please grant `ngt-permissions.editRail` in plugin permissions.

In this plugin, `negative.` permissions and `fixrtm.all_permit` added by [KaizPatchX] and [fixRTM] will not work.
Please use deny permissions and generic permission by permission management plugin.

[KaizPatchX]: https://github.com/Kai-Z-JP/KaizPatchX
[fixRTM]: https://www.curseforge.com/minecraft/mc-mods/fixrtm
