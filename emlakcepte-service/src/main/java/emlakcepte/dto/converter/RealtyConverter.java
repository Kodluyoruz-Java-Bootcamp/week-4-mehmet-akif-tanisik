package emlakcepte.dto.converter;

import emlakcepte.dto.model.response.RealtyResponse;
import emlakcepte.model.Realty;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.dto.model.request.RealtyRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RealtyConverter {

	public Realty convert(RealtyRequest realtyRequest) {
		Realty realty = new Realty();
		realty.setNo(realtyRequest.getNo());
		realty.setCreateDate(LocalDateTime.now());
		realty.setStatus(RealtyType.PASSIVE);
		realty.setTitle(realtyRequest.getTitle());
		realty.setProvince(realtyRequest.getProvince());
		return realty;
	}

	public RealtyResponse convert(Realty realty)
	{
		RealtyResponse realtyResponse =new RealtyResponse();
		realtyResponse.setTitle(realty.getTitle());
		realtyResponse.setProvince(realty.getProvince());
		realtyResponse.setUserId(realty.getUser().getId());
		realtyResponse.setRealtyNo(realty.getNo());
		realtyResponse.setRealtyType(realty.getStatus());
		return  realtyResponse;

	}

}
