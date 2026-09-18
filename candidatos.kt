fun main() {
    // Definição dos candidatos
    val candidato1 = "Candidato A"
    val candidato2 = "Candidato B"
    val candidato3 = "Candidato C"

    // Contadores de votos
    var votosC1 = 0
    var votosC2 = 0
    var votosC3 = 0
    var votosNulosBrancos = 0

    println("=== SIMULADOR DE URNA ELETRÔNICA ===")
    
    // Define o limite máximo de votos
    print("Digite o número máximo de votos (X): ")
    val limiteVotos = readln().toIntOrNull() ?: 0

    if (limiteVotos <= 0) {
        println("Número de votos inválido. Encerrando programa.")
        return
    }

    var totalVotosValidos = 0

    // Loop de votação
    while (totalVotosValidos < limiteVotos) {
        println("\n--- VOTO Nº ${totalVotosValidos + 1} de $limiteVotos ---")
        println("Opções:")
        println("1 - $candidato1")
        println("2 - $candidato2")
        println("3 - $candidato3")
        println("Qualquer outro número - Nulo/Branco")
        println("Digite 'fim' para encerrar a votação antecipadamente.")
        print("Escolha: ")

        val entrada = readln().trim().lowercase()

        // Verifica se o usuário quer finalizar
        if (entrada == "fim") {
            println("Votação encerrada pelo usuário.")
            break
        }

        // Processa o voto
        when (entrada) {
            "1" -> votosC1++
            "2" -> votosC2++
            "3" -> votosC3++
            else -> votosNulosBrancos++
        }

        totalVotosValidos++
    }

    // Gerando o relatório final
    val totalGeral = votosC1 + votosC2 + votosC3 + votosNulosBrancos

    println("\n========================================")
    println("           RELATÓRIO DA ELEIÇÃO         ")
    println("========================================")
    println("Total de votos apurados: $totalGeral")
    println("----------------------------------------")

    if (totalGeral > 0) {
        // Função interna para calcular a porcentagem
        fun calcularPorcentagem(votos: Int, total: Int): Double {
            return (votos.toDouble() / total) * 100
        }

        val pctC1 = calcularPorcentagem(votosC1, totalGeral)
        val pctC2 = calcularPorcentagem(votosC2, totalGeral)
        val pctC3 = calcularPorcentagem(votosC3, totalGeral)
        val pctNulos = calcularPorcentagem(votosNulosBrancos, totalGeral)

        // Exibe os resultados formatados com duas casas decimais
        println("$candidato1: $votosC1 votos (${String.format("%.2f", pctC1)}%)")
        println("$candidato2: $votosC2 votos (${String.format("%.2f", pctC2)}%)")
        println("$candidato3: $votosC3 votos (${String.format("%.2f", pctC3)}%)")
        println("Brancos/Nulos: $votosNulosBrancos votos (${String.format("%.2f", pctNulos)}%)")
        println("----------------------------------------")

        // Determina o vencedor considerando apenas votos nos candidatos
        val maiorVoto = maxOf(votosC1, votosC2, votosC3)

        if (maiorVoto == 0) {
            println("Resultado: Não houve votos válidos para nenhum candidato.")
        } else {
            // Cria uma lista para verificar possíveis empates
            val vencedores = mutableListOf<String>()
            if (votosC1 == maiorVoto) vencedores.add(candidato1)
            if (votosC2 == maiorVoto) vencedores.add(candidato2)
            if (votosC3 == maiorVoto) vencedores.add(candidato3)

            if (vencedores.size > 1) {
                println("Resultado: EMPATE entre os candidatos: ${vencedores.joinToString(", ")}")
            } else {
                println("VENCEDOR: ${vencedores[0]} com $maiorVoto votos!")
            }
        }
    } else {
        println("Nenhum voto foi registrado.")
    }
    println("========================================")
}
