/*
*  @author: Ademir Queiroga <admqueiroga@gmail.com>
*  @created: 27/03/21
*/

import annotations.Modelize
import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import java.io.OutputStreamWriter


class ModelizeProcessor : SymbolProcessor {

    private lateinit var codeGenerator: CodeGenerator

    override fun init(
        options: Map<String, String>,
        kotlinVersion: KotlinVersion,
        codeGenerator: CodeGenerator,
        logger: KSPLogger
    ) {
        this.codeGenerator = codeGenerator

    }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(Modelize::class.qualifiedName!!)
        symbols.filterIsInstance<KSClassDeclaration>()
            .asSequence()
            .forEach { symbol ->
                if (symbol.classKind != ClassKind.INTERFACE) {
                    throw NotAnInterfaceException()
                }
                val packageName = symbol.packageName.asString()
                val modelData = ModelData.create(packageName, symbol)
                val fileSpec = ModelGenerator.generate(modelData)
                val dependencies = Dependencies(true, *fileSpec.originatingKSFiles().toTypedArray())
                val file = codeGenerator.createNewFile(dependencies, fileSpec.packageName, fileSpec.name)
                OutputStreamWriter(file).use(fileSpec::writeTo)
            }
        return emptyList()
    }

    class NotAnInterfaceException : Exception("The annotated class must be an interface")

}