package com.edpichler.address.modelo;

import javax.swing.JPanel;

import meuaddon.RooEntityUi;

//@RooEntityUi()
public class CountryViewImpl extends JPanel implements CountryView {
	
	private CountryController controller;

	public CountryViewImpl() {
		controller = new CountryController(this);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		controller.save();
		
	}

	@Override
	public void cancel() {
		
	}

	@Override
	public void delete() {
		controller.delete();		
	}
}
