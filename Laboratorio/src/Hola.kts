import org.junit.Test
import kotlin.test.*

class LabTest {
    @Test
    fun `Given a list, whem it has multiple elements, then result list should be correct`() {
        val result = processList(
            listOf(10, "Enero", null, true)
        )
        assertNotNull(result)
        assertTrue(result.size == 3)
        assertTrue(
            result.get(0).originalPos == 0
                    && result.get(0).originalValue == 10
                    && result.get(0).type?.lowercase() == "entero"
                    && result.get(0).info?.lowercase() == "m10"
        )

        assertTrue(
            result.get(1).originalPos == 1
                    && result.get(1).originalValue == "Enero"
                    && result.get(1).type?.lowercase() == "cadena"
                    && result.get(1).info?.lowercase() == "l5"
        )
        assertTrue(
            result.get(2).originalPos == 3
                    && result.get(2).originalValue == true
                    && result.get(2).type?.lowercase() == "booleano"
                    && result.get(2).info?.lowercase() == "verdadero"
        )
    }
}




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
    //var mylist: ArrayList<Int> = ArrayList()
    var data  : ArrayList<ItemData> = ArrayList()
    var index : Int = 0

    if (inputList == null) return null

    for (item: Any? in inputList){

        when (item) {
            is Int -> {
                val itemData : ItemData = isInt(item, index)
                data.add(itemData)
            }

            is String -> {
                val itemData : ItemData = isString(item, index)
                data.add(itemData)
            }

            is Boolean -> {
                val itemData : ItemData = isBoolean(item, index)
                data.add(itemData)
            }

            else -> {}
        }
        index += 1

    }
    return data
}


fun isInt(item : Int, index: Int ) : ItemData {
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

    val itemData : ItemData = ItemData(index, item, "entero", info)
    return itemData
}


fun isString(item: String, index: Int) : ItemData{
    var info : String = "L" + item.length

    val itemData : ItemData = ItemData(index, item, "cadena", info)
    return itemData
}

fun isBoolean(item: Boolean, index: Int): ItemData{
    var info : String = "falso"

    if (item) {info = "verdadero"}

    val itemData : ItemData = ItemData(index, item, "booleano", info)
    return itemData
}