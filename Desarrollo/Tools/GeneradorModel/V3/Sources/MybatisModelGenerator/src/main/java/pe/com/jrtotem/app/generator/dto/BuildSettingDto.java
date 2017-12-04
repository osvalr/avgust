package pe.com.jrtotem.app.generator.dto;

public class BuildSettingDto {

	private Integer id_build_setting;

	private String name_setting;

	public Integer getId_build_setting() {
		return id_build_setting;
	}

	public void setId_build_setting(Integer id_build_setting) {
		this.id_build_setting = id_build_setting;
	}

	public String getName_setting() {
		return name_setting;
	}

	public void setName_setting(String name_setting) {
		this.name_setting = name_setting;
	}

	@Override
	public String toString() {
		return name_setting;
	}

}
