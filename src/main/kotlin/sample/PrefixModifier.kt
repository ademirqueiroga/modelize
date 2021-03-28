package sample

import annotations.ValueModifier

object PrefixModifier : ValueModifier<String> {
    override fun modify(source: String): String {
        return "prefix_$source"
    }
}