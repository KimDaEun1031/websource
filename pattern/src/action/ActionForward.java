package action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ActionForward {
	private String path; //어디로 갈것인가?
	private boolean redirect; //어떤 방식으로 갈것인가?(forward/sendRedirect)
}
