package com.github.antoniohbmonteiro.pixtemplates.liveTemplates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class PixContext : TemplateContextType("Pix-Templates", "Pix Templates"){
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name.endsWith(".kt")
    }
}