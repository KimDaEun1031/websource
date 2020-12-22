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
	private String path; //���� �����ΰ�?
	private boolean redirect; //� ������� �����ΰ�?(forward/sendRedirect)
}
