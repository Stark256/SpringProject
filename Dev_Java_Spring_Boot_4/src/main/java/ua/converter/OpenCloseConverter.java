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
		String[] a=arg0.split(":");
		
		LocalTime time = LocalTime.of(Integer.valueOf(a[0]), Integer.valueOf(a[1]));
		
		return reposiroty.findByTime(time);
	}
}
