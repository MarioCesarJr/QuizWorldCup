package br.com.quiz.model;

public class Pergunta {

	private int idPergunta;
	private String questao;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private String respostaCerta;
	private int nivel;

	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public String getRespostaCerta() {
		return respostaCerta;
	}

	public void setRespostaCerta(String respostaCerta) {
		this.respostaCerta = respostaCerta;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alternativaA == null) ? 0 : alternativaA.hashCode());
		result = prime * result
				+ ((alternativaB == null) ? 0 : alternativaB.hashCode());
		result = prime * result
				+ ((alternativaC == null) ? 0 : alternativaC.hashCode());
		result = prime * result
				+ ((alternativaD == null) ? 0 : alternativaD.hashCode());
		result = prime * result + idPergunta;
		result = prime * result + nivel;
		result = prime * result + ((questao == null) ? 0 : questao.hashCode());
		result = prime * result
				+ ((respostaCerta == null) ? 0 : respostaCerta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (alternativaA == null) {
			if (other.alternativaA != null)
				return false;
		} else if (!alternativaA.equals(other.alternativaA))
			return false;
		if (alternativaB == null) {
			if (other.alternativaB != null)
				return false;
		} else if (!alternativaB.equals(other.alternativaB))
			return false;
		if (alternativaC == null) {
			if (other.alternativaC != null)
				return false;
		} else if (!alternativaC.equals(other.alternativaC))
			return false;
		if (alternativaD == null) {
			if (other.alternativaD != null)
				return false;
		} else if (!alternativaD.equals(other.alternativaD))
			return false;
		if (idPergunta != other.idPergunta)
			return false;
		if (nivel != other.nivel)
			return false;
		if (questao == null) {
			if (other.questao != null)
				return false;
		} else if (!questao.equals(other.questao))
			return false;
		if (respostaCerta == null) {
			if (other.respostaCerta != null)
				return false;
		} else if (!respostaCerta.equals(other.respostaCerta))
			return false;
		return true;
	}

}
