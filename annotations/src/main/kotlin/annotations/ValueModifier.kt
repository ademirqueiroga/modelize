/*
*  @author: Ademir Queiroga <admqueiroga@gmail.com>
*  @created: 27/03/21
*/

package annotations

interface ValueModifier<T> {

    fun modify(source: T): T

}