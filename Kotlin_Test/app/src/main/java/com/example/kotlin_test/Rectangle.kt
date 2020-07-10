package com.example.kotlin_test

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width

}

fun main() {

    var r = Rectangle(19, 11)
//    println(r.isSquare)
//
//
//    r = com.example.kotlin_test.Rectangle(18, 18)
//    println(r.isSquare)

//    val rq = com.example.kotlin_test.Colorr.VIOLET
//    print(rq.rgb())


//    val view: com.example.kotlin_test.View = com.example.kotlin_test.Button()
//    view.click()
//    view.com.example.kotlin_test.showOff()

    val builder = StringBuilder("Hello")
    builder.lastIndexOf("Hello",0)
    print(builder.lastCharacter.toString())
}

var StringBuilder.lastCharacter: Char
    get() = get(length - 1)
    set(value: Char) = this.setCharAt(length - 1, value)


open class View {
    open fun click() = println("com.example.kotlin_test.View clicked")
}

class Button : View() {
    override fun click() = println("com.example.kotlin_test.Button clicked")
}

fun View.showOff() = println("I am a view!")
fun Button.showOff() = println("I am a button!")


fun String.lastChar(): Char = this.get(this.length - 1)

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Colorr(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INGIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}
