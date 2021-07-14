package com.meli.diploma.dto;

public class DiplomaDTO {
    private String mensagem;
    private double media;
    private AlunoDTO aluno;

    public DiplomaDTO(String mensagem, double media, AlunoDTO alunoDTO) {
        this.mensagem = mensagem;
        this.media = media;
        this.aluno = alunoDTO;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }
}
