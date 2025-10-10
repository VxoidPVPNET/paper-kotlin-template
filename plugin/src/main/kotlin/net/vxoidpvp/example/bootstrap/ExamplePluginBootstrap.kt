package net.vxoidpvp.example.bootstrap

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import java.time.Instant

/**
 * This class runs before the plugin is loaded.
 */
class ExamplePluginBootstrap : PluginBootstrap {

    override fun bootstrap(context: BootstrapContext) {
        val logger = context.logger
      
        logger.info(" ExamplePlugin Bootstrap is starting up! ")
        logger.info(" Plugin: ${context.pluginMeta.name} v${context.pluginMeta.version}")

        val javaVersionString = System.getProperty("java.version")
        val majorVersion = parseJavaVersion(javaVersionString)

        if (majorVersion != 21) {
            logger.warning("You are running Java $majorVersion ($javaVersionString).")
            logger.warning("It is recommended to use Java 21.")
        } else {
            logger.info("Detected Java 21")
        }

        context.pluginMeta.data["bootstrapStartTime"] = Instant.now()

        logger.info("Bootstrap completed successfully!")
    }

    /**
     * Extracts the major Java version from a version string.
     */
    private fun parseJavaVersion(version: String): Int {
        return try {
            if (version.startsWith("1.")) {
                version.substring(2, 3).toInt()
            } else {
                version.substringBefore(".").toInt()
            }
        } catch (e: Exception) {
            0
        }
    }
}
