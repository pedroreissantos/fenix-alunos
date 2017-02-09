package aluno;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

public class AtomicInterface {
	@Atomic
	public static void add(String code, String name) {
		FenixFramework.getDomainRoot().addAluno(new Aluno(name, code));
	}

	@Atomic
	public static void remove(String code) {
		for (Aluno a : FenixFramework.getDomainRoot().getAlunoSet())
			if (code.equals(a.getCode()))
				a.remove();
	}

	@Atomic
	public static void get(String code) {
		for (Aluno a : FenixFramework.getDomainRoot().getAlunoSet())
			if (code.equals(a.getCode()))
				System.out.println(a);
	}

	@Atomic
	public static void find(String regex) {
		for (Aluno a : FenixFramework.getDomainRoot().getAlunoSet())
			if (a.getName().matches(regex))
				System.out.println(a);
	}

	@Atomic
	public static void list() {
		for (Aluno a : FenixFramework.getDomainRoot().getAlunoSet())
			System.out.println(a);
	}

	@Atomic
	public static void deleteAll() {
		for (Aluno a : FenixFramework.getDomainRoot().getAlunoSet())
			a.remove();
	}
}
