package dev.fujiwara.util;

import dev.fujiwara.dto.RoujinDTO;

public class RoujinUtil {

	public static String rep(RoujinDTO roujinDTO){
		return rep(roujinDTO.futanWari);
	}

	public static String rep(int futanWari){
		return "老人" + futanWari + "割";
	}
}
