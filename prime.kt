import kotlin.math.sqrt
fun isPrime(n:Int):Boolean{
    if (n < 2) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}
fun main() {
    print("Enter the upper limit (n): \n")
    val n = readLine()?.toIntOrNull() ?: 100
    
    for(i in 1..n){
        if(isPrime(i)){
            println(i)
        }
    }
    
}
