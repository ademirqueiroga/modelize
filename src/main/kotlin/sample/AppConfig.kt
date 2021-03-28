package sample

import annotations.Create
import annotations.Modelize


interface Config {

    val configProperty: String

}

interface Style {

    val styleProperty: String

}

interface AnotherInterface {

    val anotherProperty: String

}

@Modelize
interface AppConfig : Config, Style, AnotherInterface {

    @Create("newProp", PrefixModifier::class)
    override val anotherProperty: String

}