package ua.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;

import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;

public class OpenCloseConverter implements Converter<String, OpenClose> {

	private final OpenCloseRepository reposiroty;

	public OpenCloseConverter(OpenCloseRepository reposiroty) {
		super();
		this.reposiroty = reposiroty;
	}

	@Override
	public OpenClose convert(String arg0) {
		System.out.println("--------------------------");
		System.out.println("arg0");
		System.out.println("--------------------------");
		return reposiroty.findByTime(LocalTime.of(23, 00));
	}

}
