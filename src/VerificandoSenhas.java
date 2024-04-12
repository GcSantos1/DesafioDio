import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class VerificandoSenhas {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite a senha para verificar a força:");
        String senha = br.readLine();

        String resultado = verificarForcaSenha(senha);
        System.out.println(resultado);
    }

    public static String verificarForcaSenha(String senha) {
        int comprimentoMinimo = 8;


        boolean temLetraMaiuscula = senha.matches(".*[A-Z].*");
        boolean temLetraMinuscula = senha.matches(".*[a-z].*");
        boolean temNumero = senha.matches(".*\\d.*");
        boolean temCaractereEspecial = senha.matches(".*\\W.*");
        boolean temSequenciaComum = senha.matches(".*(?i)123456.*|.*(?i)abcdef.*");
        boolean temPalavraComum = senha.equalsIgnoreCase("password") || senha.equalsIgnoreCase("123456") || senha.equalsIgnoreCase("qwerty");


        if (senha.length() < comprimentoMinimo) {
            return "Sua senha e muito curta. Recomenda-se no minimo 8 caracteres.";
        } else if (!temLetraMaiuscula) {
            return "A senha deve conter pelo menos uma letra maiúscula.";
        } else if (!temLetraMinuscula) {
            return "A senha deve conter pelo menos uma letra minúscula.";
        } else if (!temNumero) {
            return "A senha deve conter pelo menos um número.";
        } else if (!temCaractereEspecial) {
            return "Sua senha nao atende aos requisitos de seguranca.";
        } else if (temSequenciaComum) {
            return "A senha não pode conter sequências comuns.";
        } else if (temPalavraComum) {
            return "A senha não pode ser uma palavra comum.";
        } else {
            return "Sua senha atende aos requisitos de seguranca. Parabens!";
        }
    }
}
