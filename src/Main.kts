enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("$usuario foi matriculado na formação $nome")
    }
}

fun main() {
    // Criação de alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    // Criação de uma formação
    val formacao = Formacao("Formação em Kotlin", Nivel.INTERMEDIARIO)

    // Adiciona conteúdos à formação
    formacao.conteudos.add(conteudo1)
    formacao.conteudos.add(conteudo2)
    formacao.conteudos.add(conteudo3)

    // Simulação de matrícula de usuários
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Lista de inscritos na formação
    println("Inscritos na formação ${formacao.nome}:")
    formacao.inscritos.forEachIndexed { index, usuario ->
        println("${index + 1}. ${usuario.nome}")
    }
}
