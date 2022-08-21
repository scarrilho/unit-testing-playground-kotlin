package tddbyexample

data class Pair(val from: String, val to: String ) {
    override fun equals(other: Any?): Boolean =
        other is Pair && other.from == from && other.to == to

    override fun hashCode(): Int {
        return 0
    }
}