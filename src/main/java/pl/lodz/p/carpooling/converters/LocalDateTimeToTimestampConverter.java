package pl.lodz.p.carpooling.converters;

import org.joda.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

/**
 * @author Adrian Szwajkowski.
 */
@Converter(autoApply = true)
public class LocalDateTimeToTimestampConverter implements AttributeConverter<LocalDateTime, Timestamp>
{
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return attribute == null ? null : new Timestamp(attribute.toDateTime().getMillis());
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return dbData == null ? null : LocalDateTime.fromDateFields(dbData);
	}
}
