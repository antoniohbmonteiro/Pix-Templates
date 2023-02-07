package com.github.antoniohbmonteiro.pixtemplates.other.setup

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.antoniohbmonteiro.pixtemplates.other.setup.src.app_package.someActivity
import com.github.antoniohbmonteiro.pixtemplates.other.setup.src.app_package.someActivityLayout


fun RecipeExecutor.mviSetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)

    val activityClass = "${entityName}sActivity"
    val activityTitle = "$entityName Activity"
    // This will generate new manifest (with activity) to merge it with existing
    generateManifest(
        activityClass = activityClass,
        packageName = packageName,
        hasNoActionBar = true,
        generateActivityTitle = true,
        isLauncher = false,
        moduleData = moduleData
    )

    save(
        someActivity(packageName, entityName, layoutName, projectData),
        srcOut.resolve("$activityClass.kt")
    )
    save(
        someActivityLayout(packageName, entityName),
        resOut.resolve("layout/$layoutName.xml")
    )
}