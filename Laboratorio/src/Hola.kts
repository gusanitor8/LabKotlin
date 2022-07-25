// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var array : ArrayList<ItemData> = ArrayList<ItemData>()
    if (inputList == null) return null

    var index : Int = 0
    inputList.forEach{
        if (it != null){
            when(it){
                is String -> {array.add(ItemData(index,it,"cadena", "L" + it.length))}
                is Boolean -> {array.add(ItemData(index,it,"booleano", if (it) "verdadero" else "falso"))}
                is Int -> {array.add(ItemData(index,it,"entero", isInt(it)))}
            }
        }
        index += 1
    }

    return array
}

fun isInt(item : Int) : String? {
    var info : String? = ""

    when{
        item % 10 == 0 -> {
            info = "M10"
        }
        item % 5 == 0 -> {
            info = "M5"
        }
        item % 2 == 0 -> {
            info = "M2"
        }
        item == null -> {
            info = null
        }
    }
    return info
}
/**
 * Cómo verificar el tipo de objeto?
 * when (myAnyTypeElement) {
 * 	is String -> TODO()
 *  is Int -> TODO()
 *  is Boolean -> TODO()
 * 	else -> TODO()
 * }
 */

/**
 * Cómo declarar una función en una variable?
 * val myFuncVar = { x: Any -> TODO() }
 */

/**
 * Cómo crear un objeto de nuestra clase?
 * val newItem = ItemData(
 * 	originalPos = 0,
 * 	originalValue = "hola"
 * 	type = "cadena"
 * 	info = "L4"
 * )
 */