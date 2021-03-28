/*
*  @author: Ademir Queiroga <admqueiroga@gmail.com>
*  @created: 27/03/21
*/

package annotations



/**
 * Allows a property of an interface to receive the
 * default [Int] [value] when it's implementation is being
 * generated
 *
 * @param value the value to assign to the property
 */
@MustBeDocumented
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class IntDefault(val value: Int)

/**
 * Allows a property of an interface to receive the
 * default [String] [value] when it's implementation is being
 * generated
 *
 * @param value the value to assign to the property
 */
@MustBeDocumented
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class StringDefault(val value: String)

/**
 * Allows a property of an interface to receive the
 * default [Boolean] [value] when it's implementation is being
 * generated
 *
 * @param value the value to assign to the property
 */
@MustBeDocumented
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class BooleanDefault(val value: Boolean)
