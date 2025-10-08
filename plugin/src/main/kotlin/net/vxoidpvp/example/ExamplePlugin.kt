package net.vxoidpvp.example

import net.axay.kspigot.main.KSpigot

class ExamplePlugin : KSpigot() {

    override fun load() {
        logger.info("Loading Example Plugin...")
    }

    override fun startup() {
        logger.info("Enable Example Plugin")
    }

    override fun shutdown() {
        logger.info("Shutdown Example Plugin")
    }
}