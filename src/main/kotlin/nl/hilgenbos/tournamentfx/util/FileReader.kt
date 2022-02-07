package nl.hilgenbos.tournamentfx.util

import javafx.scene.control.Alert
import nl.hilgenbos.tournamentfx.model.WorkspaceModelManager
import tornadofx.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream

object FileReader {

    /** Open file from resources on classpath */
    fun openFileFromResources(filename: String) {
        val text =  this::class.java.classLoader.getResource(filename).readText()
        WorkspaceModelManager.textModel.textProperty.set(text)
     }


    /** Open a file and set the text in the textArea */
    fun openFile(targetFile: File) {

        if (!canOpenFile(targetFile)) {
            return
        }

        try {
            //val text = file.readText(Charsets.UTF_8)
            val text = readFileWithBuffer(targetFile)
            WorkspaceModelManager.textModel.textProperty.set(text)
            WorkspaceModelManager.fileModel.fileProperty.set(targetFile)
        } catch (e: Exception) {
            println(e)
        }
    }



    /** Check whether file can open */
    fun canOpenFile(targetFile: File): Boolean {
        if (isBigFile(targetFile)) {
            val alertHeader = "File size limit"
            val alertContent = "File size is too large.\nYou can only open files within " +
                    displayFileSize(Constant.OPEN_FILE_SIZE_LIMIT_BYTE) + "."
            alert(Alert.AlertType.WARNING, alertHeader, alertContent)
            return false
        }

        return true
    }

    /** Is the file too big?
     *
     * @param targetFile: Check this file size whether over the limit
     */
    fun isBigFile(targetFile: File): Boolean {
        return (targetFile.length() > Constant.OPEN_FILE_SIZE_LIMIT_BYTE)
    }

    /** Read the file rapidly  */
    fun readFileWithBuffer(file: File): String {
        val inputStream = BufferedInputStream(FileInputStream(file))

        return inputStream.bufferedReader(Charsets.UTF_8).use(BufferedReader::readText)
    }

    /** Display the readable file size
     *
     * @param fileSizeByte: File size (Byte)
     * @return Display the size with the unit for the byte
     */
    fun displayFileSize(fileSizeByte: Long): String {
        var displaySize = fileSizeByte
        var counter = 0

        while (true) {
            if (displaySize < 1_000 || counter > 2) {
                when (counter) {
                    0 -> return "$displaySize Byte"
                    1 -> return "$displaySize KB"
                    2 -> return "$displaySize MB"
                    else -> return "$displaySize GB"
                }
            } else {
                ++counter
                displaySize /= 1_000
            }
        }
    }
}