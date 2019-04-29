package com.s4ds.utilidades;

public class validations {

	// espacios en blanco: este metodo devuelve true si el campo solo tiene espacios
	// en blanco
	public boolean campoEspaciosBlanco(String campo) {

		return campo.equals(" ") || campo.equals("  ") || campo.equals("   ") || campo.equals("    ")
				|| campo.equals("     ") || campo.equals("      ") || campo.equals("       ")
				|| campo.equals("        ") || campo.equals("         ") || campo.equals("          ")
				|| campo.equals("           ") || campo.equals("            ") || campo.equals("             ")
				|| campo.equals("              ") || campo.equals("               ") || campo.equals("                ")
				|| campo.equals("                 ") || campo.equals("                  ")
				|| campo.equals("                   ") || campo.equals("                    ");
	}

	public boolean caracteresExtraños(char[] vecChar, int i) {

		while (i != vecChar.length) {
			int ascii = (int) vecChar[i];
			if (ascii >= 0 || ascii <= 64) {
				return true;
			}
			if (ascii >= 91 || ascii <= 96) {
				return true;
			}
			if (ascii >= 123 || ascii <= 163) {
				return true;
			}
			if (ascii >= 166 || ascii <= 255) {
				return true;
			}
			i += 1;
		}

		return false;
	}

	public boolean esNumero(String campo) {
		try {
			Double.parseDouble(campo);
			return true;
		} catch (NumberFormatException excepcion) {
			return false;
		}
	}



}
