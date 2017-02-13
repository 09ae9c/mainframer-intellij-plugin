package com.elpassion.intelijidea.task

import com.elpassion.intelijidea.util.mfFilename
import com.intellij.execution.BeforeRunTask
import java.io.File
import java.io.Serializable

class MFBeforeRunTask(var data: MFTaskData) : BeforeRunTask<MFBeforeRunTask>(MFBeforeRunTaskProvider.ID) {

    fun isValid() = data.isValid()
}

data class MFTaskData(val mainframerPath: String? = null,
                      val buildCommand: String? = null,
                      val taskName: String? = null) : Serializable {

    fun isValid(): Boolean = listOf(mainframerPath, buildCommand, taskName).none { it.isNullOrBlank() } && isMfFileExistent()

    private fun isMfFileExistent() = File(mainframerPath, mfFilename).exists()
}