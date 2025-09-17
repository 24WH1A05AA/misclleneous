fun main() {
    
    print("Enter the first string: ")
    val string1 = readlnOrNull( ) ?: ""//a damm

    print("Enter the second string: ")
    val string2 = readlnOrNull( ) ?: ""//input=madam

    if (areAnagrams(string1, string2)) {
        println("'$string1' and '$string2' are anagrams. ")
    } else {
        println("'$string1' and '$string2' are not anagrams.")
    }
}



fun areAnagrams(s1: String, s2: String): Boolean {
    val processedS1 = s1.replace("\\s+".toRegex(), "").lowercase()
    val processedS2 = s2.replace("\\s".toRegex(), "").lowercase()

    if (processedS1.length != processedS2.length) {
        return false
    }

    return processedS1.toCharArray().sorted() == processedS2.toCharArray().sorted()
}
