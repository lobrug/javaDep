package util;

public class ValidarCPF {

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (todosDigitosIguais(cpf)) {
            return false;
        }

        try {
            int[] digitos = new int[11];
            for (int i = 0; i < 11; i++) {
                digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
            }

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += digitos[i] * (10 - i);
            }
            int digitoVerificador1 = 11 - (soma % 11);
            if (digitoVerificador1 == 10 || digitoVerificador1 == 11) {
                digitoVerificador1 = 0;
            }

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += digitos[i] * (11 - i);
            }
            int digitoVerificador2 = 11 - (soma % 11);
            if (digitoVerificador2 == 10 || digitoVerificador2 == 11) {
                digitoVerificador2 = 0;
            }

            return digitoVerificador1 == digitos[9] && digitoVerificador2 == digitos[10];

        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean todosDigitosIguais(String cpf) {
        char firstDigit = cpf.charAt(0);
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != firstDigit) {
                return false;
            }
        }
        return true;
    }
}