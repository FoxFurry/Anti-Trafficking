import java.io.IOException


object Analyze {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        // TODO(developer): Replace these variables before running the sample.
//        val filePath = "/home/foxfurry/IdeaProjects/Anti_Trafficking/samples/test_flowers.jpeg"
//
//        val imageScan = ProcessImage(filePath)
//        println("${(imageScan.getResult()*100).toInt()}%")

        val textScan = ProcessText("1 2 3 4 5 6")


//        val translate = TranslateOptions.getDefaultInstance().service
//        val translation = translate.translate("¡Hola Mundo!")
//        System.out.printf("Translated Text:\n\t%s\n", translation.translatedText)
//        LanguageServiceClient.create().use { language ->
//            val test_text = "I want to cum. I want to fuck you. I am a nigger with giant dick and massive balls. "
//            val doc = Document.newBuilder().setContent(test_text).setType(Document.Type.PLAIN_TEXT).build()
//            val request = ClassifyTextRequest.newBuilder().setDocument(doc).build()
//            // detect categories in the given text
//            val response = language.classifyText(request)
//            for (category in response.categoriesList) {
//                System.out.printf(
//                    "Category name : %s, Confidence : %.3f\n",
//                    category.name, category.confidence
//                )
//            }
//        }
    }






}