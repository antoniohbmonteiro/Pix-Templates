package com.github.antoniohbmonteiro.pixtemplates.services

import com.intellij.openapi.project.Project
import com.github.antoniohbmonteiro.pixtemplates.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }

    /**
     * Chosen by fair dice roll, guaranteed to be random.
     */
    fun getRandomNumber() = 4
}
