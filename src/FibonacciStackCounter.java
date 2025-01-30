import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ett program som förklarar hur rekursiva fibonaccianrop skapas och hur de returnerar sina värden. Den skriver ut
 * allting som händer i programmet och loggar hur stacken förändras för varje gång vi pushar eller poppar någonting.
 * Den genererar även ett simpelt diagram som visar hur det rekursiva anropsträdet ser ut. En webbsida skapas
 * automatiskt för att illustrera resultaten.
 * @author Carl-Johan Johansson
 * @since 2025-01-29
 * @version 1.0
 */
public class FibonacciStackCounter
{
    private static final StringBuilder html = new StringBuilder();
    private static final char[] letters = new char[26];
    private static int counter = 0;
    private static final List<Character> callStack = new ArrayList<>();
    private static final StringBuilder recursiveTree = new StringBuilder();
    private static BufferedWriter stackWriter;
    private static final String PUSH_COLOR = "#14CD70";
    private static final String RETURN_COLOR = "#2ab9b4";
    private static final String POP_COLOR = "#FB6078";
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static String equation = "";

    /**
     * Main-metod som initialiserar variablerna och sparkar igång koden
     * @param args Eventuella argument från kommandoraden
     * @throws IOException Eventuellt undantagsfel som kastas om inte BufferedWriter går att initialisera
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        //Fyller arrayen med bokstäver
        for (int i = 0; i < letters.length; i++)
            letters[i] = (char) ('A' + i);

        stackWriter = new BufferedWriter(new FileWriter("output_tmp_files/CallstackLog.csv", false));
        BufferedWriter treeWriter = new BufferedWriter(new FileWriter("output_tmp_files/RecursiveMethodTree.txt", false));

        Scanner scan = new Scanner(System.in);
        int n = -1;
        while (n < 0 || n > 6)
        {
            System.out.println(YELLOW + "\nVilket tal i fibonaccisekvensen vill du beräkna? (Välj 0-6)" + COLOR_RESET);
            n = scan.nextInt();
        }

        StringBuilder programOutput = new StringBuilder();
        PrintStream originalOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArray);
        System.setOut(newOut);

        fib(n, "", true);

        System.setOut(originalOut);
        programOutput.append(byteArray);
        treeWriter.write(recursiveTree.toString());
        treeWriter.close();
        stackWriter.close();
        System.out.println(YELLOW + "\nRekursivFibonacci.html har genererats i output_tmp_files." + COLOR_RESET);
        Thread.sleep(400);
        createWebpage(n, programOutput);

        BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("output_tmp_files/RekursivFibonacci.html", false));
        htmlWriter.write(html.toString());
        htmlWriter.close();
        openWebpage();
    }

    /**
     * En modifierad rekursiv fibonacci som associerar varje anrop med en bokstav och sedan skriver ut hur de pushas
     * till och poppas från stacken, för att illustrera hur de rekursiva anropen fungerar enligt principen djupet först.
     * @param n Det nummer i fibonaccisekvensen som vi vill beräkna
     * @return  Det uträknade numret
     */
    public static long fib(int n, String prefix, boolean isTopLevel) throws IOException
    {
        char currentLetter = letters[counter++];
        String pushMessage = String.format("<span style='color:%s;'>Pushar fib(%d) med ID %c på stacken.</span>", PUSH_COLOR, n, currentLetter);
        System.out.println(pushMessage);
        callStack.add(currentLetter);
        logCallStack();

        recursiveTree.append(prefix).append(currentLetter).append(": fib(").append(n).append(")\n");

        if (n <= 1)
        {
            String returnMessage = String.format("<span style='color:%s;'>fib(%d) med ID %c returnerar värdet %d.</span>", RETURN_COLOR, n, currentLetter, n);
            System.out.println(returnMessage);
            logCallStack();

            String popMessage = String.format("<span style='color:%s;'>Poppar %c från stacken.</span>", POP_COLOR, currentLetter);
            System.out.println(popMessage);
            callStack.remove(callStack.size() - 1);
            logCallStack();
            return n;
        }

        char leftLetter = letters[counter];
        long left = fib(n - 1, prefix + "   ", false);

        char rightLetter = letters[counter];
        long right = fib(n - 2, prefix + "   ", false);
        long result = left + right;

        String returnMessage = String.format("<span style='color:%s;'>fib(%d) med ID %c returnerar värdet %d.</span>", RETURN_COLOR, n, currentLetter, result);
        System.out.println(returnMessage);
        logCallStack();

        String popMessage = String.format("<span style='color:%s;'>Poppar %c från stacken.</span>", POP_COLOR, currentLetter);
        System.out.println(popMessage);
        callStack.remove(callStack.size() - 1);
        logCallStack();

        if (isTopLevel)
            equation = "fib(" + currentLetter + ") = fib(" + leftLetter + ") + fib(" + rightLetter + ")";

        return result;
    }

    /**
     * Loggar vad stacken innehåller för varje rad i programutskriften
     * @throws IOException Eventuellt undantagsfel som kastas
     */
    private static void logCallStack() throws IOException
    {
        String stackContents = String.join(", ", callStack.stream().map(String::valueOf).toArray(String[]::new));
        stackWriter.write(stackContents);
        stackWriter.newLine();
        stackWriter.flush();
    }

    /**
     * Hjälpmetod för StringBuilder-klassen så att vi kan lägga till innehåll från filer i html-strängen.
     * @param filePath Sökvägen för filen
     * @throws IOException Eventuellt undantagsfel som kastas
     */
    private static void appendFileContent(String filePath) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = br.readLine()) != null)
                FibonacciStackCounter.html.append(line).append("\n");
        }
    }

    /**
     * Öppnar automatiskt html-filen i webbläsaren när programmet körts färdigt.
     */
    private static void openWebpage()
    {
        try
        {
            File htmlFile = new File("output_tmp_files/RekursivFibonacci.html");
            if (Desktop.isDesktopSupported()) Desktop.getDesktop().browse(htmlFile.toURI());
            else System.err.println("Kan inte öppna html-filen automatiskt.");
        }
        catch (IOException e)
        {
            System.err.println("Fel när html-filen skulle öppnas: " + e.getMessage());
        }
    }

    /**
     * Hjälpmetod för att räkna ut formeln för det angivna numret
     * @param n Numret i fibonaccisekvensen som ska beräknas
     */
    private static void appendFibonacciToHtml(int n)
    {
        html.append("""
        <div class="right-section-wrapper">
        <section id="Fibonacci">
        """);

        if (n > 1)
            html.append("Fibonacci(").append(n).append(") = Fibonacci(").append(n - 1).append(") + Fibonacci(").append(n - 2).append(")");
        else if (n == 1)
            html.append("Fibonacci(1) = 1");
        else if (n == 0)
            html.append("Fibonacci(0) = 0");

        if (!equation.isEmpty())
            html.append("<p>").append(equation).append("</p>");

        html.append("""
                </section>
                """);
    }

    public static void createWebpage(int n, StringBuilder programOutput) throws IOException
    {
        html.append("""
            <!DOCTYPE html>
            <html lang="sv">
            <head>
            <title>Fibonacci Stack Counter</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=2" />
            <link rel="stylesheet" href="../assets/reset.css">
            <link rel="stylesheet" href ="../assets/style.css">
            </head>
            <body>
            <main>
            <section id="Method">
            <h2>Metoden som anropas:</h2>
            <br><br>
            <p>public long fib(int n)<br>
            {<br>
            &nbsp;&nbsp;&nbsp;if (n <= 1) return n;<br>
            <br>
            &nbsp;&nbsp;&nbsp;return fib(n-1) + fib(n-2);<br>
            }</p>
            </section>""");

        appendFibonacciToHtml(n);

        html.append("""
                <div class="flex-container">
                <section id="ProgramFlow">
                <h2>Vad som händer i programmet</h2>
                <pre>
                """);
        html.append(programOutput);
        html.append("</pre>\n</section>\n");
        html.append("<section id=\"StackCounter\">\n<h2>Vad stacken innehåller</h2>\n<pre>\n");
        appendFileContent("output_tmp_files/CallstackLog.csv");
        html.append("</pre>\n</section>\n");
        html.append("<section id=\"RecursiveTree\">\n<h2>Hur det rekursiva trädet ser ut</h2>\n<pre>\n");
        appendFileContent("output_tmp_files/RecursiveMethodTree.txt");
        html.append("</pre>\n</section>\n");
        html.append("</main></div></div></body>\n</html>");
    }
}
