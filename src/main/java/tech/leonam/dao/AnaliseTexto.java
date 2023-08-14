package tech.leonam.dao;

public class AnaliseTexto {
    /*


    public static final String[] ESPECIAIS = {
            "backspace",
            "up",
            "down",
            "right",
            "left",
            "tab",
            "enter",
            "esc",
            "comma",
            "shift",
            "quote",
            "alt",
            "back",
            "ctrl",
            "quoteback",
            "space",
            "semicolon"
    };
 */

    public String trocas(String aSerEnviado) {
        var retorno = aSerEnviado;
        retorno = trocarTabPorQuatroEspacos(retorno);
        retorno = semicolonPorPontoEVirgula(retorno);
        retorno = trocaSpacePorEspacoDeVerdade(retorno);
        retorno = trocarCommaPorVirgula(retorno);
        retorno = remocaoDeAlgunsEspeciais(retorno);
        retorno = igualEmInglesEmSimbolo(retorno);
        retorno = minusEmSimbolo(retorno);
        return retorno;
    }
    private String minusEmSimbolo(String retorno) {
        return retorno.replace("minus", "-");
    }

    private String igualEmInglesEmSimbolo(String retorno) {
        return retorno.replace("equals", "=");
    }

    private String remocaoDeAlgunsEspeciais(String retorno) {
        return retorno.replace("quote", "").replace("back", "<-").replace("alt"," alt ").replace("shift"," shift ");
    }

    public String trocaSpacePorEspacoDeVerdade(String retorno) {
        return retorno.replace("space", " ");
    }

    public String semicolonPorPontoEVirgula(String retorno) {
        return retorno.replace("semicolon", ";");
    }

    public String trocarTabPorQuatroEspacos(String retorno) {
        return retorno.replace("tab", " tab ");
    }

    public String trocarCommaPorVirgula(String retorno) {
        return retorno.replace("comma", ",");
    }
}
