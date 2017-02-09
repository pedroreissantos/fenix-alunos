package aluno;

import aluno.AlunoException;

import pt.ist.fenixframework.FenixFramework;

public class Aluno extends Aluno_Base {
	public static final int CODE_SIZE = 5;

	public Aluno(String name, String code) {
		setName(name);
		setCode(code);
	}

	@Override
	public void setName(String name) {
		if (name.length() == 0)
			throw new AlunoException("No name given");
		for (Aluno a: FenixFramework.getDomainRoot().getAlunoSet())
			if (a.getName().equals(name))
				throw new AlunoException("Duplicate name: "+name);
		super.setName(name);
	}

	@Override
	public void setCode(String code) {
		if (code.length() != Aluno.CODE_SIZE)
			throw new AlunoException("Code size error: "+code.length());
		for (Aluno a: FenixFramework.getDomainRoot().getAlunoSet())
			if (a.getCode().equals(code))
				throw new AlunoException("Duplicate code: "+code);
		super.setCode(code);
	}

	public void remove() {
		setRoot(null);
		deleteDomainObject();
	}

	@Override
	public String toString() {
		return getCode() + " " + getName();
	}
}
