package pe.com.acme.inoiceelec.util;

import java.util.List;

public class ProcessInfoDto {
	private int numSuccess;
	private int numError;
	private List<GeneratedDocInfoDto> generatedDocInfoDtos;

	public int getNumSuccess() {
		return numSuccess;
	}

	public void setNumSuccess(int numSuccess) {
		this.numSuccess = numSuccess;
	}

	public List<GeneratedDocInfoDto> getGeneratedDocInfoDtos() {
		return generatedDocInfoDtos;
	}

	public void setGeneratedDocInfoDtos(List<GeneratedDocInfoDto> generatedDocInfoDtos) {
		this.generatedDocInfoDtos = generatedDocInfoDtos;
	}

	public int getNumError() {
		return numError;
	}

	public void setNumError(int numError) {
		this.numError = numError;
	}

}
