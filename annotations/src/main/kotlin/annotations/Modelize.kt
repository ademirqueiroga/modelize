/*
*  @author: Ademir Queiroga <admqueiroga@gmail.com>
*  @created: 27/03/21
*/

package annotations


/**
 * @param delegatedClass tells if a class for a delegated constructor should be generated.
 *
 *  A delegate class a class where the implementation of its inherited interfaces
 *  is delegated to the parameters received in it's constructor.
 *
 *  Example:
 *
 *  interface Bundle : Config, Styles, Settings
 *
 *  class Properties(...) : Bundle {
 *      ...
 *  }
 *
 *  class DelegatedProperties(
 *      config: Config,
 *      styles: Styles,
 *      settings: Settings,
 *  ): Bundle,
 *     Config by config,
 *     Styles by styles,
 *     Settings by settings {
 *  }
 *
 */
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Modelize(
    val name: String = CLASS_NAME,
    val delegatedClass: Boolean = false,
) {

    companion object {
        const val CLASS_NAME = ""
    }

}
