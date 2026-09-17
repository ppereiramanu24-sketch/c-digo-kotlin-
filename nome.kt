fun main() {
    // Listas com os nomes e sobrenomes
    val nomes = listOf("Ana", "Bruno", "Carlos")
    val sobrenomes = listOf("Silva", "Souza", "Oliveira")

    // Garante que o loop use o tamanho da menor lista para evitar erros de índice
    val tamanho = minOf(nomes.size, sobrenomes.size)

    println("--- Nomes Completos Gerados ---")
    for (i in 0 until tamanho) {
        // Junta o nome e o sobrenome usando String Templates
        val nomeCompleto = "${nomes[i]} ${sobrenomes[i]}"
        println(nomeCompleto)
    }
}
