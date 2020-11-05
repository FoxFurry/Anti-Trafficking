class StringAnalyze constructor(_str: String) {

    // Hardcoded array of badWords
    private val badWords: Array<String> = arrayOf("cum", "dick", "shit")

    // Input string is converted into slices
    private var str_slices: List<String> = _str.split(' ', ',', '.').map { it.trim(); it.toLowerCase() }


    // This is what we use from main
    //
    // Inp: none
    // Out: result: Double   [0,1] where 0 means absolutely safe and 1 means absolutely dangerous

    public fun analyze(): Double {
        var result = 0.0

        str_slices.forEach{

        }


        return result
    } // analyze





    // Check if word is suspucious
    //
    // Inp: s: String   Normalized word
    // Out: _: Boolean  true if s is suspicious and false in toher case

    private fun isSuspicious(s: String): Boolean {

        return false
    } // isSuspicious


    // Levenshtein's distance algorithm.
    //
    // Inp: s: String   First string which will be compared
    //      t: String   Second string which will be compared
    // Out: _: Int      Levenshtein's distance between s and t

    private fun levenshtein(
        s: String, t: String,
        charScore: (Char, Char) -> Int = { c1, c2 -> if (c1 == c2) 0 else 1 }
    ): Int {
        if (s == t) return 0
        if (s == "") return t.length
        if (t == "") return s.length

        val initialRow: List<Int> = (0 until t.length + 1).map { it }.toList()
        return (s.indices).fold(initialRow, { previous, u ->
            (t.indices).fold(mutableListOf(u + 1), { row, v ->
                row.add(
                    minOf(
                        row.last() + 1,
                        previous[v + 1] + 1,
                        previous[v] + charScore(s[u], t[v])
                    )
                )
                row
            })
        }).last()
    } // levenshtein


}