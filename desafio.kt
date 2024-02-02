enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario {
    override fun toString(): String {
        return "Usuario(${hashCode()})"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    fun alterarDuracao(novaDuracao: Int) {
        duracao = novaDuracao
    }
}

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("$usuario matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun listarInscritos() {
        inscritos.forEach {
            println(it.toString())
        }
    }
}

fun main() {
    val usuario1 = Usuario()
    val usuario2 = Usuario()

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Desenvolvimento Kotlin")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    formacao.listarInscritos()

    // Teste de alteração da duração do conteúdo educacional
    conteudo1.alterarDuracao(120)

    // Teste de remoção de conteúdo educacional
    formacao.removerConteudo(conteudo2)
}
