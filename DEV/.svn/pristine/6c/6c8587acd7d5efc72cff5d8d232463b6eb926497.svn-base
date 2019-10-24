package com.yaic.app.common.vo;

import java.util.List;

public class DatatablesView<T> {
	private List<T> data;

	private long recordsTotal;

	private long recordsFiltered;

	private int draw;

	public DatatablesView() {
	}
	
	public int getDraw () {
        return draw;
    }

    public DatatablesView<T> setDraw ( int draw ) {
        this.draw = draw;
        return this;
    }

    public List<T> getData() {
		return data;
	}

	public DatatablesView<T> setData(List<T> data) {
		this.data = data;
		return this;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public DatatablesView<T> setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
		return this;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public DatatablesView<T> setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
		return this;
	}
}
