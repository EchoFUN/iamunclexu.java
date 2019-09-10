package com.iamunclexu.confs

import com.iamunclexu.confs.Constant.TEMPLATE_DOCUMENT
import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import org.slf4j.LoggerFactory
import java.io.File
import java.io.IOException

class TemplateConf {

    fun init() {
        configuration = Configuration()
        try {
            val templatePath = "${SysConf.FRONTEND_ROOT}$TEMPLATE_DOCUMENT"

            LOGGER.info("Template dir is : $templatePath")
            configuration.templateLoader = FileTemplateLoader(File(templatePath))
        } catch (e: IOException) {
            LOGGER.error(e.message)
        }

    }

    companion object {

        private val LOGGER = LoggerFactory.getLogger(TemplateConf::class.java)
        private lateinit var templateConf: TemplateConf

        private lateinit var configuration: Configuration

        fun inst(): TemplateConf {
            templateConf = TemplateConf()
            return templateConf
        }

        fun fetchConfiguration(): Configuration? {
            return configuration
        }
    }
}
