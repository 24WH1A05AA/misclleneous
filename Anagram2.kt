
data class AnagramDifference(val missing: List<Char>, val extra: List<Char>)

fun main() {
    
    print("Enter the first string: ")
    val string1 = readlnOrNull() ?: ""

    print("Enter the second string: ")
    val string2 = readlnOrNull() ?: ""

    
    val freqMap1 = createFrequencyMap(string1)
    val freqMap2 = createFrequencyMap(string2)
    
    
    println("\n--- Character Frequencies ---")
    printFrequencyMap("For '$string1'", freqMap1)
    printFrequencyMap("For '$string2'", freqMap2)
    println("---------------------------\n")

    if (freqMap1 == freqMap2) {
        println("Result: The strings are perfect anagrams.")
    } else {
        println("Result: The strings are not anagrams.")
         
        val difference = findAnagramDifference(freqMap1, freqMap2)

        if (difference.missing.isNotEmpty()) {
            println("Characters missing from the second string: ${difference.missing}")
        }
        if (difference.extra.isNotEmpty()) {
            println("Extra characters found in the second string: ${difference.extra}")
        }
    }
}


fun createFrequencyMap(s: String): Map<Char, Int> {
    
    val cleanedString = s.replace(" ", "").lowercase()
    
    return cleanedString.groupingBy { it }.eachCount()
}


fun findAnagramDifference(map1: Map<Char, Int>, map2: Map<Char, Int>): AnagramDifference {
    val missing = mutableListOf<Char>()
    val extra = mutableListOf<Char>()

    val allChars = map1.keys + map2.keys

    for (char in allChars) {
        val count1 = map1.getOrDefault(char, 0)
        val count2 = map2.getOrDefault(char, 0)
        
        val diff = count1 - count2

        if (diff > 0) { 
            repeat(diff) { missing.add(char) }
        } else if (diff < 0) { 
            repeat(-diff) { extra.add(char) }
        }
    }
   
    return AnagramDifference(missing.sorted(), extra.sorted())
}


fun printFrequencyMap(title: String, map: Map<Char, Int>) {
    println(title)
    if (map.isEmpty()) {
        println("  (empty)")
        return
    }
    
    map.toSortedMap().forEach { (char, count) ->
        println("  '$char' -> $count")
    }
}
