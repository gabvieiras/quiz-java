package models;

public class Pergunta {
    private String enunciado;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private String opcao4;
    private String resposta;
    private int pesoPergunta;

    public Pergunta() {

    }
    public int getPesoPergunta() {
        return pesoPergunta;
    }

    public void setPesoPergunta(int pesoPergunta) {
        this.pesoPergunta = pesoPergunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public String getOpcao4() {
        return opcao4;
    }

    public String getResposta() {
        return resposta;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void inertQuestion(String[] question, int pesoPergunta) {
        setEnunciado(question[0]);
        setOpcao1(question[1]);
        setOpcao2(question[2]);
        setOpcao3(question[3]);
        setOpcao4(question[4]);
        setResposta(question[5]);
        setPesoPergunta(pesoPergunta);
    }
}
