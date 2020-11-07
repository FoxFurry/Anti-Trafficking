import com.google.cloud.language.v1.ClassifyTextRequest
import com.google.cloud.language.v1.Document
import com.google.cloud.language.v1.LanguageServiceClient
import com.google.cloud.translate.TranslateOptions
import kotlin.math.ceil

class ProcessText constructor(inputString: String) {
    private var text = inputString

    init{
        if(text.isNotEmpty())
            process()
        else
            println("Bad string")

    }

    private fun process(){
        translateText()

        println(text)
        if(text.length < 100){
            val textSlices = text.split(' ').toMutableList()
            if(textSlices.size < 20){
                val tempSlices = textSlices.toList()

                while(textSlices.size < 20){
                    textSlices += tempSlices
                }
                text = textSlices.joinToString(" ")
            }
        }
        println(text)

        LanguageServiceClient.create().use { language ->
            val doc = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build()
            val request = ClassifyTextRequest.newBuilder().setDocument(doc).build()
            // detect categories in the given text
            val response = language.classifyText(request)
            for (category in response.categoriesList) {
                System.out.printf(
                    "Category name : %s, Confidence : %.3f\n",
                    category.name, category.confidence
                )
            }
        }
    }

    private fun translateText(){
        val translate = TranslateOptions.getDefaultInstance().service
        text = translate.translate(text).translatedText
    }
}