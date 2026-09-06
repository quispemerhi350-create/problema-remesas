fun main()
{
    println("=== PROBLEMA DE REMESAS ===")

    val montos = listOf(1000.0, 1500.0, 20000.0, 500.0)

    for (t in montos)
    {
        val itf = calcularITF(t)
        val mr = calcularMontoRemesa(t)
        val comision = calcularComision(mr)
        println("-------------------------------")
        println("Monto total (T): " + t)
        println("ITF: " + itf)
        println("Comision: " + comision)
        println("Monto de remesa (mr): " + mr)
    }
}
fun calcularITF(t: Double): Double
{
    return t * 0.00005
}
fun calcularComision(mr: Double): Double
{
    if (mr <= 1000)
        return 5.0
    else if (mr <= 10001)
        return mr * 0.005
    else
        return mr * 0.015
}
fun calcularMontoRemesa(t: Double): Double
{
    val itf = calcularITF(t)
    val mr1 = t - itf - 5.0
    if (mr1 <= 1000)
        return mr1
    val mr2 = (t - itf) / 1.005
    if (mr2 > 1000 && mr2 <= 10001)
        return mr2
    val mr3 = (t - itf) / 1.015
    return mr3
}
