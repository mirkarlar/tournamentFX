package nl.hilgenbos.tournamentfx.model

object WorkspaceModelManager {
    val textModel = TextModel()
    val fileModel = FileModel()

    fun reset() {
        textModel.reset()
        fileModel.reset()
    }
}